import { useEffect, useState } from "react";
import type { AnalyticsSummary } from "../types/analytics";
import { getAnalyticsSummary } from "../api/analyticsApi";

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

  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <h1 className="text-3xl font-bold mb-6">Dashboard</h1>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        <div className="bg-white rounded-2xl shadow p-6">
          <h2 className="text-sm text-gray-500">Total Members</h2>
          <p className="text-3xl font-bold">{data.totalMembers}</p>
        </div>

        <div className="bg-white rounded-2xl shadow p-6">
          <h2 className="text-sm text-gray-500">Active Subscriptions</h2>
          <p className="text-3xl font-bold">{data.activeSubscriptions}</p>
        </div>

        <div className="bg-white rounded-2xl shadow p-6">
          <h2 className="text-sm text-gray-500">Total Revenue</h2>
          <p className="text-3xl font-bold">₹{data.totalRevenue}</p>
        </div>
      </div>
    </div>
  );
}

export default DashboardPage;
