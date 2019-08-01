package br.com.alura.horas.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//dura ate a execucao do codigo;
@Retention(RetentionPolicy.RUNTIME)
//anotacao que só pode ser utilizado em metodos para liberar acesso, mesmo sem o usuario logado
@Target(ElementType.METHOD)
public @interface Open {

}
