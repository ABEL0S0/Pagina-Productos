import { Menubar } from 'primereact/menubar'
import { useNavigate } from 'react-router-dom';

export const Navigation = () => {
    const navigate = useNavigate();

    const navlist = [
        {label:'Home', icon:'pi pi-fw pi-home', command: () => navigate('/')},
        {label:'About', icon:'pi pi-fw pi-file', command: () => navigate('/about')},
        {label:'Contact', icon:'pi pi-fw pi-phone', command: () => navigate('/contact')},
        {label:'Table', icon:'pi pi-fw pi-table', command: () => navigate('/table')}
    ];

    return (
        <div>
            <header>
                <nav>
                    <ul>
                        <Menubar model={navlist} onCommand={(e) => e.command()} />
                    </ul>
                </nav>
            </header>
        </div>
    )
}