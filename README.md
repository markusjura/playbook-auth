# Authentication Service
Handles the authentication. The following users are valid:
- user-0 to user-99

Password for all users is `pass`.

More details can be found in the [REST API documentation](http://playbook-auth.herokuapp.com)

#### How to start
The service is hosted on [http://playbook-auth.herokuapp.com](http://playbook-auth.herokuapp.com). You can use your local
`authService` by:

1. Changing the `service.auth.url` in the *eplay application.conf* to your URL
    ```
    service.auth.url="http://localhost:9001"
    ```

2. Starting the local `authService`
    ```
    $ cd authService
    $ activator
    > start 9001
    ```
