import { Navigate, Route, Routes } from "react-router-dom";
import { NavBar } from "../components/NavBar";
import { ComprasPage } from "./Compraspage";
import {Carritopage} from "./Carritopage"
import { ProductsProvider } from "../Context/ProductsProvider";
import { CarritoProvider } from "../Context/CarritoProvider";

export default function Home() {
    return (
        <ProductsProvider>
            <CarritoProvider>
                <NavBar />
                <div className="container">
                    <Routes>
                        <Route path="/" element={<ComprasPage />} />
                        <Route path="/carrito" element={<Carritopage />} />
                        <Route path="*" element={<Navigate to="/" />} />
                    </Routes>
                </div>
            </CarritoProvider>
        </ProductsProvider>
    );
}
