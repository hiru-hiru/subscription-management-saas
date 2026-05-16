import { Link, useLocation } from "react-router-dom";

const menuItems = [
  { label: "Dashboard", path: "/" },
  { label: "Members", path: "/members" },
  { label: "Plans", path: "/plans" },
  { label: "Subscriptions", path: "/subscriptions" },
  { label: "Payments", path: "/payments" },
  { label: "Coupons", path: "/coupons" },
];

function Sidebar() {
	const location = useLocation();

	return (
		<aside className="w-64 bg-slate-900 text-white min-h-screen p-6">
		<h1 className="text-2xl font-bold mb-8">Subscription SaaS</h1>

		<nav className="space-y-2">
			{
				menuItems.map((item) => {
					const isActive = location.pathname === item.path;

					return (
						<Link
						key={item.path}
						to={item.path}
						className={`block px-4 py-3 rounded-xl transition ${
							isActive ? "bg-blue-600" : "hover:bg-slate-800"
						}`}
						>
						{item.label}
						</Link>
					);
				})
			}
		</nav>
		</aside>
	);
}

export default Sidebar;
