
// import Sidebar from '../Components/Sidebar/Sidebar';
// import Header from '../Components/Header/Header';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminDashboard from '../Layout/AdminDashboard';
import Random from '../Components/Random';

const AppRoutes = () => {
    return (

        <BrowserRouter>
            <Routes>
                <Route path='/' element={<AdminDashboard />}>
                    <Route path='/dashboard' element={<Random />} />
                    <Route path='/doctors' element={<Random />} />
                    <Route path='/patients' element={<Random />} />
                    <Route path='/appointments' element={<Random />} />
                    <Route path='/pharmacy' element={<Random />} />
                    <Route path='/medicines' element={<Random />} />
                    <Route path="/billing" element={<Random />} />
                    <Route path="/lab-reports" element={<Random />} />
                    <Route path="/nurses" element={<Random />} />
                    <Route path="/medical-records" element={<Random />} />
                    <Route path="/beds" element={<Random />} />
                    <Route path="/emergency" element={<Random />} />
                    <Route path="/ambulance" element={<Random />} />
                    <Route path="/staff" element={<Random />} />
                    <Route path="/inventory" element={<Random />} />
                    <Route path="/feedback" element={<Random />} />
                </Route>
            </Routes>
            {/* <AdminDashboard /> */}
        </BrowserRouter>

    )
}

export default AppRoutes

