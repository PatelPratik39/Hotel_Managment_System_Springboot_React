
import Sidebar from '../Components/Sidebar/Sidebar';
import Header from '../Components/Header/Header';


const AppRoutes = () => {
    return (
        <>
            <div className='flex'>
                <Sidebar />
                <div className='w-full'><Header /></div>
            </div>
            
        </>
    )
}

export default AppRoutes