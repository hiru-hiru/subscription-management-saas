import { useEffect, useState } from 'react'
import { getMembers } from '../api/MembershipApi'
import type { Member } from '../types/member'

function MembersPage() {
  const [members, setMembers] = useState<Member[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  const ORGANIZATION_ID = 1 // Temporary hardcoded value

  useEffect(() => {
    getMembers(ORGANIZATION_ID)
      .then(setMembers)
      .catch(() =>
        setError('Failed to load members'),
      )
      .finally(() => setLoading(false))
  }, [])

  if (loading) {
    return <div className="p-6">Loading...</div>
  }

  if (error) {
    return (
      <div className="p-6 text-red-600">
        {error}
      </div>
    )
  }

  return (
    <div>
      <h1 className="text-3xl font-bold mb-6">
        Members
      </h1>

      <div className="bg-white rounded-2xl shadow p-6">
        <h2 className="text-xl font-semibold mb-4">
          Organization Members
        </h2>

        {members.length === 0 ? (
          <p className="text-gray-500">
            No members found.
          </p>
        ) : (
          <table className="w-full text-left">
            <thead>
              <tr className="border-b">
                <th className="py-2">Membership ID</th>
                <th className="py-2">Name</th>
                <th className="py-2">Email</th>
                <th className="py-2">Phone</th>
                <th className="py-2">Role</th>
                <th className="py-2">Status</th>
              </tr>
            </thead>

            <tbody>
              {members.map((member) => (
                <tr
                  key={member.membershipId}
                  className="border-b"
                >
                  <td className="py-2">
                    {member.membershipId}
                  </td>
                  <td className="py-2">
                    {member.name}
                  </td>
                  <td className="py-2">
                    {member.email}
                  </td>
                  <td className="py-2">
                    {member.phone}
                  </td>
                  <td className="py-2">
                    {member.role}
                  </td>
                  <td className="py-2">
                    {member.membershipStatus}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  )
}

export default MembersPage