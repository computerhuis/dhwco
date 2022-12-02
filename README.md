# dhwco

Data Warehouse Werkgroep Computerhuis Oost

# dhwco commandline starten

Plaats de otap stellingen van in `~/Projects/computerhuis/dhwco-runtime/application-otap.yaml`

```yaml
# https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
spring:
    # ==================================================================================================================
    # = DATA SOURCE
    # ==================================================================================================================
    datasource:
        url: jdbc:mariadb://localhost:3306/dco
        username: dco
        password: geheim

```

Om dhwco rechtstreeks te starten, voeren we het volgende commando via de terminal uit:

```shell
java -jar dhwco-1.0.0-SNAPSHOT.war --spring.config.additional-location=file:~/Projects/computerhuis/dhwco-runtime/
```

Tijden het starten kijk dhwco in het bestand `~/Projects/computerhuis/dhwco-runtime/application-otap.yaml` voor de aanvullende
instellingen.

Voor meer informatie zie:
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config.files

### Development mode

Development mode zet alle caching uit en zet extra logging aan, voeren we het volgende commando via de terminal uit:

```shell
```shell
java -jar dhwco-1.0.0-SNAPSHOT.war --spring.config.additional-location=file:~/Projects/computerhuis/dhwco-runtime/ --spring.profiles.active=development
```
