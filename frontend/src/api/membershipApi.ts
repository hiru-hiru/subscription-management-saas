import axios from "axios";
import { API_BASE_URL } from "../config";
import type { Member } from "../types/member";

export async function getMembers(organizationId: number) :Promise<Member[]> {
    const response = await axios.get<Member[]>(`${API_BASE_URL}/memberships?organizationId=${organizationId}`)
    return response.data
}