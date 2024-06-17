import "./styles/home.css";
import { Navigate, Route, Routes } from "react-router-dom";
import { NavBar } from "../components/NavBar";
import { ComprasPage } from "./Compraspage";
import { Carritopage } from "./Carritopage";
import { ProductsProvider } from "../Elements/ProductProvider";
import { CarritoProvider } from "../Elements/CarritoProvider";
import  Adminlogin from "./adminlogin.jsx"
import AdminProduct from "./adminProduct.jsx"


export const Home = () => {


  return (
    <ProductsProvider>
        <CarritoProvider>
            <NavBar />
            <div className="container">
                <Routes>
                    <Route path="/" element={<ComprasPage />} />
                    <Route path="/carrito" element={<Carritopage />} />
                    <Route path="/adminlogin" element={<Adminlogin />} />
                    <Route path="/adminProduct" element={<AdminProduct />} />
                    <Route path="*" element={<Navigate to="/" />} />
                </Routes>
            </div>
        </CarritoProvider>
    </ProductsProvider>
);
}
