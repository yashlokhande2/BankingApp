import API from "./api";

export const registerUser = async (userData) => {
    return API.post("/users/register", userData);
};

export const loginUser = async (credentials) => {
    return API.post("/users/login", credentials);
};
       