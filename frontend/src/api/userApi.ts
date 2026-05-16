import axios from "axios";
import type { CreateUserRequest, User } from "../types/user";
import { API_BASE_URL } from "../config";

export async function getUsers(): Promise<User[]> {
    const response = await axios.get<User[]>(`${API_BASE_URL}/users`)
    return response.data
}

export async function createUser(request: CreateUserRequest): Promise<User> {
    const response = await axios.post<User>(`${API_BASE_URL}/users`, request)
    return response.data
}