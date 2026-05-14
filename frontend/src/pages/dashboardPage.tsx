import { useEffect, useState } from "react";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";
import { getAnalyticsSummary } from "../api/analyticsApi";
import type { AnalyticsSummary } from "../types/analytics";

function DashboardPage() {
  const [data, setData] = useState<AnalyticsSummary | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    getAnalyticsSummary(1)
      .then(setData)
      .catch(() => setError("Failed to load analytics data"))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <div className="p-6">Loading...</div>;
  if (error) return <div className="p-6 text-red-600">{error}</div>;
  if (!data) return null;

  const cards = [
    { label: "Total Members", value: data.totalMembers },
    { label: "Active Members", value: data.activeMembers },
    { label: "Active Subscriptions", value: data.activeSubscriptions },
    { label: "Expiring in 7 Days", value: data.expiringIn7Days },
    { label: "Total Coupon Usage", value: data.couponUsageCount },
    { label: "Total Revenue", value: `₹${data.totalRevenue}` },
  ];

  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <h1 className="text-3xl font-bold mb-8">Dashboard</h1>

      {/* KPI Cards */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-8">
        {cards.map((card) => (
          <div key={card.label} className="bg-white rounded-2xl shadow p-6">
            <h2 className="text-sm text-gray-500">{card.label}</h2>
            <p className="text-3xl font-bold mt-2">{card.value}</p>
          </div>
        ))}
      </div>

      {/* Coupon Usage Chart */}
      <div className="bg-white rounded-2xl shadow p-6">
        <h2 className="text-xl font-semibold mb-4">Coupon Usage</h2>

        {data.couponUsageStats.length === 0 ? (
          <p className="text-gray-500">No coupon usage data available.</p>
        ) : (
          <div className="h-80">
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={data.couponUsageStats}>
                <XAxis dataKey="code" />
                <YAxis />
                <Tooltip />
                <Bar dataKey="usageCount" />
              </BarChart>
            </ResponsiveContainer>
          </div>
        )}
      </div>
    </div>
  );
}

export default DashboardPage;
