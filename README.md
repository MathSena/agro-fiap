# agro-fiap
Trabalho feito na matéria de INTEGRATIONS &amp; DEVELOPMENT TOOLS da turma 43scj MBA em Fullstack development

## Desafio
O desafio proposto é desenvolver uma solução para o agronegócio, com coleta de dados via sensores de temperatura e umidade. Esses sensores ficarão instalados em um drone com uma altíssima economia pois conta com pequenos, porém muito eficientes, painéis fotovoltaicos. 
A cada 10 segundos são enviados para message broker os dados de temperatura e umidade capturado naquele instante.

1.	A cada 10 segundos é feito uma leitura dos dados (temperatura e umidade) e os dados enviados para um serviço de mensagens.
2.	O microsserviço deve enviar um alerta (pode ser um email) quando em 1 minuto:
a.	Temperatura (>= 35 ou <=0) ou (Umidade <= 15%).
b.	Envie no corpo do e-mail o id_drone e os valores capturados.

Requisitos: 
•	Código publicado no GitHub.
•	Readme.md (use os estilos para formatação) com detalhes do projeto, de como subir, configurar, printscreen com o funcionamento da aplicação, ou um vídeo.
•	Pense na implementação que possa suportar vários drones, desta forma considere isso para o funcionamento dos alarmes e do rastreamento.
•	Use RabbitMQ ou Apache Kafka.

## Solução

Para o desafio de criar uma solução para o agronegócio, foi proposta uma solução baseada em mensageria, utilizando o Java, Spring e o Rabbit MQ, conforme apresentado no quadro abaixo: 

•	DRONE: Dispositivo capaz de realizar leituras do ambiente o qual esta inserido e envia-las para a aplicação AGROFIAP-PRODUCER.
•	AGROLIB-FIAP: Biblioteca em java contendo classes utilizadas pelas aplicações AGROFIAP-PRODUCER e AGROFIAP-CONSUMER.
•	AGROFIAP-PRODUCER: Interface disponibilizada ao drone para envio dos dados referentes às leituras que são encaminhadas para a fila do RABBIT MQ.
•	RABBIT MQ: Servidor de mensageria.
•	AGROFIAP-CONSUMER: Aplicação responsável por processar as leituras dos drones e envio de emails alertas conforme necessário
![image](https://github.com/MathSena/agro-fiap/assets/33051907/6db52889-538b-4cf8-b07a-21b1709165b2)



## Como rodar o projeto

## Tecnologias utilizas

