// import { IconHeartbeat, IconLayoutGrid, IconStethoscope, IconEmergencyBed, IconCalendarCheck, IconVaccine, IconPillFilled, IconCash, IconReportMedical, IconUserNurse, IconFileMedical, IconBed, IconAlertTriangle, IconTruckDelivery, IconUsers, IconClipboardList, IconBuildingHospital, IconUser, IconLogout } from '@tabler/icons-react'
import { Avatar, Text } from '@mantine/core';
import { NavLink } from 'react-router-dom';
import {
  IconHeartbeat,
  IconLayoutGrid,
  IconStethoscope,
  IconEmergencyBed,
  IconCalendarCheck,
  IconVaccine,
  IconPillFilled,
  IconCash,
  IconReportMedical,
  IconUserCheck,
  IconFileText,
  IconBed,
  IconAlertTriangle,
  IconTruckDelivery,
  IconUsers,
  IconClipboardList,
  IconMessageDots
} from '@tabler/icons-react';


const links = [
  { name: "Dashboard", url: "/dashboard", icon: <IconLayoutGrid stroke={1.5} /> },
  { name: "Doctors", url: "/doctors", icon: <IconStethoscope stroke={1.5} /> },
  { name: "Patients", url: "/patients", icon: <IconEmergencyBed stroke={1.5} /> },
  { name: "Appointments", url: "/appointments", icon: <IconCalendarCheck stroke={1.5} /> },
  { name: "Pharmacy", url: "/pharmacy", icon: <IconVaccine stroke={1.5} /> },
  { name: "Medicines", url: "/medicines", icon: <IconPillFilled stroke={1.5} /> },
  { name: "Billing", url: "/billing", icon: <IconCash stroke={1.5} /> },
  { name: "Lab Reports", url: "/lab-reports", icon: <IconReportMedical stroke={1.5} /> },
  { name: "Nurses", url: "/nurses", icon: <IconUserCheck stroke={1.5} /> },
  { name: "Medical Records", url: "/medical-records", icon: <IconFileText stroke={1.5} /> },
  { name: "Beds", url: "/beds", icon: <IconBed stroke={1.5} /> },
  { name: "Emergency", url: "/emergency", icon: <IconAlertTriangle stroke={1.5} /> },
  { name: "Ambulance", url: "/ambulance", icon: <IconTruckDelivery stroke={1.5} /> },
  { name: "Staff", url: "/staff", icon: <IconUsers stroke={1.5} /> },
  { name: "Inventory", url: "/inventory", icon: <IconClipboardList stroke={1.5} /> },
  { name: "Feedback", url: "/feedback", icon: <IconMessageDots stroke={1.5} /> },
];

const Sidebar = () => {
  return (
    <div className='flex'>
      <div className='w-64'>

      </div>

      <div className='w-64 fixed bg-[#212529] flex flex-col gap-7 items-center hide-scrollbar h-screen overflow-y-auto'>
        <div className='fixed z-[500] py-3 bg-[#212529] text-[#168b82] flex gap-1 items-center '>
          <IconHeartbeat size={40} stroke={2.5} />
          <span className='font-heading font-semibold text-3xl'>Pulse</span>
        </div>
        <div className=' flex flex-col mt-20 gap-5'>

          <div className='flex flex-col gap-1 items-center'>
            <div className='p-4 bg-white rounded-full shadow-lg'>
              <Avatar variant="filled" src="avtar.jpg" size="xl" alt="it's me" />
            </div>
            <span className=' font-medium text-white'>John Doe</span>
            <Text c="dimmed" className='text-light' size='xs'>Admin</Text>
          </div>
          <div className='flex flex-col gap-1'>
            {
              links.map((link) => {
                return <NavLink to={link.url} key={link.url}
                  className={({ isActive }) => `flex items-center gap-3 w-full font-medium text-neutral-900 text-white px-4 py-5 rounded-lg 
            ${isActive ? "bg-[#168b82] text-[#212529]" : "hover:bg-gray-100 hover:text-[#212529] "} `}>
                  {link.icon}<span>{link.name}</span></NavLink>
              })
            }
          </div>
        </div>
      </div>
    </div>
  )
}

export default Sidebar