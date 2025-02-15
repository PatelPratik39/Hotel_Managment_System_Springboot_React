
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
                </Route>
            </Routes>
            {/* <AdminDashboard /> */}
        </BrowserRouter>

    )
}

export default AppRoutes

