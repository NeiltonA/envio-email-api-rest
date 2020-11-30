# envio-email-api-rest
Api de envio de email em spring boot

Abaixo um exemplo  de Request/Postman:
{
"name":"Teste",
"email": "seuemail@gmail.com",
"subject":"Teste API",
"message":"Realizando teste de envio de email"
}

URL-> para teste local:
http://localhost:8090/api/v1/email

No arquivo application.properties:
adicionar seu email/ senha para autenticação

Caso sua conta do google bloqueia o envio: 
vai na opção "gerenciar sua conta do google"-> "segurança" -> "Acesso a app menos seguro" ative a opção "Permitir aplicativos menos seguros: ATIVADA"

"Sucesso" os envios dos seus e-mails vão funcionar corretamente. 
