# COMANDO PARA OS ENDPOINTS

1. Visualizar todas assinaturas:
http://localhost:8080/servcad/subscriptions

2. Ver assinaturas por cliente:
http://localhost:8080/servcad/subscriptions/{id}

3. Assinaturas por status:
http://localhost:8080/servcad/subscriptions/status/{status}

4. Cancelar assinatura:
http://localhost:8080/servcad/subscriptions/{id}/cancel

5. Todos apps:
http://localhost:8080/applications

6. Buscar app por id:
http://localhost:8080/applications/{id}

7. Info cliente por id:
http://localhost:8080/clients/{id}

8. Nova assinatura:
http://localhost:8080/servcad/subscriptions/new

Enviar como json no body

{

  "clientId": 11,
  
  "applicationId": 1
  
}
