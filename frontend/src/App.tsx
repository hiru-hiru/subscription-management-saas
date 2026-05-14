import {
  BrowserRouter,
  Routes,
  Route,
} from 'react-router-dom'

import AppLayout from './components/AppLayout'
import DashboardPage from './pages/DashboardPage'
import MembersPage from './pages/MembersPage'
import PlansPage from './pages/PlansPage'
import SubscriptionsPage from './pages/SubscriptionsPage'
import PaymentsPage from './pages/PaymentsPage'
import CouponsPage from './pages/CouponsPage'

function App() {
	return (
		<BrowserRouter>
		<Routes>
			<Route element={<AppLayout />}>
			<Route path="/" element={<DashboardPage />} />
			<Route path="/members" element={<MembersPage />} />
			<Route path="/plans" element={<PlansPage />} />
			<Route
				path="/subscriptions"
				element={<SubscriptionsPage />}	
			/>
			<Route
				path="/payments"
				element={<PaymentsPage />}
			/>
			<Route
				path="/coupons"
				element={<CouponsPage />}
			/>
			</Route>
		</Routes>
		</BrowserRouter>
	)
}

export default App