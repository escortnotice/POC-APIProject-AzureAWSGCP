1) This is a POC which will connect to multiple cloud providers services like AWS, AZURE and GCP.

2) The database used is Postgres

3) The exception handling is done in a robust way with custom error/success messages sent to front end.
3.1) API Error Message Response format:
{
    "success": false,
    "message": "Bad Request",
    "timestamp": "2019/08/22 13:55:50",
    "error": {
        "error-message": "Bad Request",
        "error-code": 4000,
        "error-data": "POST method not supported"
    }
}
3.2) API SuccessMessage Response Format:
{
    "success": true,
    "message": "Heroes Searched Successfully",
    "timestamp": "2019/08/21 19:34:01",
    "data": [
        {
            "name": "Batman",
            "id": 1
        },
        {
            "name": "Bombasto",
            "id": 3
        }
    ]
}

4) There is an api for checking the health of the application.
GET http://localhost:8080/api/v1/health

5) To run the jar using the given environment specific properties file below is the command
> java -jar -Dspring.profiles.active=dev POC-APIProject-AzureAWS-0.0.1-SNAPSHOT.jar

The above command will use the "application-dev.properties" file and values in that file
will override the values in the "application.properties" file when the application is started.

