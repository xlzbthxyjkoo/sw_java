class GameApiClient {
    static SERVER_URL = "http://localhost:8081";
    static GET_LEADERBOARD = "/leaders";
    static GET_USERS_BY_IDS = "/stats";

    static leaderBoard() {
        return fetch(GameApiClient.SERVER_URL + GameApiClient.GET_LEADERBOARD);
    }

    static getStats(userId) {
        return fetch(GameApiClient.SERVER_URL + GameApiClient.GET_USERS_BY_IDS + "?userId=" + userId);
    }
}
export default GameApiClient;