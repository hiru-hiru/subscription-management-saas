export interface CouponUsageStats{
    code: String
    usageCount: number
}

export interface AnalyticsSummary {
    totalMembers: number
    activeMembers: number
    activeSubscriptions: number
    totalRevenue: number
    expiringIn7Days: number
    couponUsageCount: number
    couponUsageStats: CouponUsageStats[]
}