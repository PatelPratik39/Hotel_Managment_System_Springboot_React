import { ActionIcon } from '@mantine/core';
import { IconLayoutSidebarLeftCollapseFilled } from '@tabler/icons-react';

const Header = () => {
    return (
        <>
            <div className='bg-cyan-200 w-full h-16'>
                <ActionIcon variant="outline" aria-label="Settings">
                    <IconLayoutSidebarLeftCollapseFilled style={{ width: '70%', height: '70%' }} stroke={1.5} />
                </ActionIcon>
            </div>
        </>
    )
}

export default Header