class ApiClient {
    static SERVER_URL = 'http://localhost:8080';
    static POST_RESULT = '/results';
    static GET_BY_ALIAS = "/results?alias=";

    static sendChoice(user, choice) {
        return fetch(ApiClient.SERVER_URL + ApiClient.POST_RESULT, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userAlias: user,
                userChoice: choice,
            }),
        });
    }
    static getAttempts(userAlias) {
        return fetch(ApiClient.SERVER_URL + ApiClient.GET_BY_ALIAS + userAlias);
    }
}

export default ApiClient;