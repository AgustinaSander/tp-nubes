Ejecutar el comando: docker-compose -f mysql.yml -p mysql-infra up --build -d
- “-f” indica cual es el archivo de configuración a utilizar
- “-p” indica que agruparemos los contenedores con el nombre de proyecto “mysql-infra”
- “up” indica que levante los contenedores
- “build” indica que de ser necesario construya las imágenes mediante el Dockerfile
- “-d” indica que luego de levantar los contenedores siga ejecutando en segundo plano
