import axios from "axios";
import type { AnalyticsSummary } from "../types/analytics";


const API_BASE_URL = 'http://localhost:8080'

export async function getAnalyticsSummary(organizationId:number): Promise<AnalyticsSummary> {
    const response = await axios.get<AnalyticsSummary>(
        `${API_BASE_URL}/analytics/summary`,
        {
            params:{
                organizationId
            }
        }
    )

    return response.data
}