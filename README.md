###Usage examples:

curl -X POST -H "Content-Type: application/json" -d '{"user_name":"alex"}' http://localhost:8088/user
{"id":2}

curl -X GET http://localhost:8088/user/0
{"id":0,"name":"alex"}

curl -X POST -H "Content-Type: application/json" -d '{"user_id":0,"currency":"usd","value":100}' http://localhost:8088/account
{"account_id":0}

curl -X POST -H "Content-Type: application/json" -d '{"user_id":0,"currency":"usd","value":200}' http://localhost:8088/account
{"account_id":1}

curl -X GET http://localhost:8088/account/0
{"id":0,"currency":"usd","value":100}

curl -X GET http://localhost:8088/account/user/0
[0,1]

curl -X POST -H "Content-Type: application/json" -d '{"from":0,"to":1,"currency":"usd","value":20}' http://localhost:8088/transfer
{"execution_date":1504513417291}


###Error description

curl -X GET http://localhost:8088/user/123
{"message":"user not found: 123"}