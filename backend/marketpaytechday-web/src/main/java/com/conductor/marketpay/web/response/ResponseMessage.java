package com.conductor.marketpay.web.response;

public class ResponseMessage {

	private ResponseMessage() {}

	public static final String MSG_GENERIC_SUCCESS = "Requisição realizada com sucesso.";
	public static final String MSG_GET_SUCCESS = "Dados localizados com sucesso.";
	public static final String MSG_POST_SUCCESS = "Dados cadastrados com sucesso.";
	public static final String MSG_PUT_SUCCESS = "Dados atualizados com sucesso.";
	public static final String MSG_DELETE_SUCCESS = "Dados removidos com sucesso.";
	
	public static final String MSG_GENERIC_ERROR = "Ocorreu um erro na requisição.";
	public static final String MSG_GET_ERROR = "Dados não encontrados, por favor verifique os dados informados.";
	public static final String MSG_POST_ERROR = "Não foi possível realizar o cadastro, verifique os dados informados.";
	public static final String MSG_PUT_ERROR = "Não foi possível realizar a atualização, verifique os dados informados.";
	public static final String MSG_DELETE_ERROR = "Não foi possível excluir, por favor verifique os dados informados.";
		
	public static final String MSG_GET_OBJECT_ID_ERROR = "Objeto não localizado, por favor verifique se o ID informado é valido.";
}
