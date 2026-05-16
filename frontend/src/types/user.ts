export interface User {
    id: number
    name: string
    email: string
    phone: string
}

export interface CreateUserRequest {
    name: string
    email: string
    phone: string
}