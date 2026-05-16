export interface Member {
    membershipId: number
    userId: number
    name: String
    email: String
    phone: String
    role: 'ADMIN' | 'MEMBER'
    membershipStatus: 'ACTIVE' | 'INACTIVE' | 'PENDING'
}