import axios from "axios";
import type { AnalyticsSummary } from "../types/analytics";
import { API_BASE_URL } from "../config";


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