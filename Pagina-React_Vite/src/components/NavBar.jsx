import { Badge } from "@mui/material";
import { ShoppingCart } from "@mui/icons-material";
import Home from '@mui/icons-material/Home';
import { NavLink } from "react-router-dom";
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';

export const NavBar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light nav">
            <div className="container-fluid">
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <NavLink to='/home' className="nav-link active" aria-current="page">
                                <Home color="action" />
                                Productos
                            </NavLink>
                        </li>
                    </ul>
                    <ul className="navbar-nav ms-auto mb-2 mb-lg-0 d-flex align-items-center">
                        <li className="nav-item">
                            <NavLink to='/home/carrito' className="nav-link">
                                <Badge color="secondary">
                                    <ShoppingCart color="action" />
                                </Badge>
                                Carrito
                            </NavLink>
                        </li>
                    </ul>
                    <ul className="navbar-nav ms-auto mb-2 mb-lg-0 d-flex align-items-center">
                        <li className="nav-item">
                            <NavLink to='/home/adminlogin' className="nav-link">
                                <Badge color="secondary">
                                    <AdminPanelSettingsIcon color="action" />
                                </Badge>
                                Admin
                            </NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}

