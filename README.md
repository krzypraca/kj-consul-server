# kj-consul-server

## consul-docker
vi /home/kj/docker/docker-compose.yml

consul1:

  command: "-server -bootstrap -ui-dir /ui"

  container_name: consul1

  image: "progrium/consul:latest"

  hostname: "consul1"

  ports:

    - "8400:8400"

    - "8500:8500"

    - "54:53"

  volumes:

   - /etc/localtime:/etc/localtime:ro


sudo docker-compose up


### test consul
http://0.0.0.0:8500/ui/

## docker-mongo

mkdir mongo_data

sudo docker pull mongo

sudo docker run --name mongo1 -v /home/kj/mongo_data:/seed-data -p 27017:27017 -d mongo --storageEngine wiredTiger


sudo docker exec -ti mongo1 /bin/bash 

mongo

show dbs ;

use admin

var me={user:"kj", pwd: "...", roles:["userAdminAnyDatabase", "readWriteAnyDatabase"]}

db.createUser(me)

exit


mongo localhost:27017/admin --username kj --password password

use db1

db.createUser(

    {

      user: "kj",

      pwd: "...",

     roles: [

         { role: "readWrite", db: "db1" }

      ]

    }

) ;

exit ;


mongo localhost:27017/db1 --username kj --password password


## test
mvn clean package

mvn spring-boot:run


http://0.0.0.0:8500/ui/#/dc1/services

http://localhost:8081/contacts

