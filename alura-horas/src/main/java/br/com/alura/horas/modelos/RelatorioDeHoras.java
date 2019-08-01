package br.com.alura.horas.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RelatorioDeHoras {

	private List<HorasPorDia> horasPorDia = new ArrayList<>();

	public RelatorioDeHoras(List<HoraLancada> horas) {
		calculaHorasPorDia(horas);
	}

	private void calculaHorasPorDia(List<HoraLancada> horas) {
		if (!horas.isEmpty()) {
			double horasDoDia = 0.0;
			Calendar dataAtual = horas.get(0).getData();
			for (HoraLancada hora : horas) {
				if (!hora.getData().equals(dataAtual)) {
					double horasNormais = Math.min(8.0, horasDoDia);
					double horasExtras = Math.max(horasDoDia - 8, 0);
					HorasPorDia horaPorDia = new HorasPorDia(horasNormais, horasExtras, dataAtual);
					this.horasPorDia.add(horaPorDia);
					dataAtual = hora.getData();
					horasDoDia = 0.0;
				}
				horasDoDia += hora.getDuracao();
			}
			double horasNormais = Math.min(8.0, horasDoDia);
			double horasExtras = Math.max(horasDoDia - 8, 0);
			HorasPorDia horasPorDia = new HorasPorDia(horasNormais, horasExtras, dataAtual);
			this.horasPorDia.add(horasPorDia);
		}
	}

	public List<HorasPorDia> getHorasPorDia() {
		return horasPorDia;
	}
}