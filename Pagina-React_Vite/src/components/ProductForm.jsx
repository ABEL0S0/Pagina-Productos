import  { useState } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';



const ProductForm = ({ onProductAdded }) => {
    const [nombre, setNombre] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [precio, setPrecio] = useState('');
    const [categoria, setCategoria] = useState('');
    const [stock, setStock] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/producto/save', {
                nombre,
                descripcion,
                precio,
                id_categoria: categoria, // Asegúrate de que el nombre del campo coincida con el modelo de Producto en Spring Boot
                stock
            });
            if (response.status === 200) {
                // Si el producto se guarda correctamente, llama a la función onProductAdded para actualizar la lista
                onProductAdded(response.data);
                // Limpiar los campos del formulario
                setNombre('');
                setDescripcion('');
                setPrecio('');
                setCategoria('');
                setStock('');
            }
        } catch (error) {
            console.error('Error al guardar el producto: ', error);
        }
    };

    return (
        <div className="containerpf">
            <h2>Agregar Producto</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Nombre:</label>
                    <input type="text" value={nombre} onChange={(e) => setNombre(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Descripción:</label>
                    <textarea value={descripcion} onChange={(e) => setDescripcion(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Precio:</label>
                    <input type="number" value={precio} onChange={(e) => setPrecio(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Categoría:</label>
                    <input type="text" value={categoria} onChange={(e) => setCategoria(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label>Stock:</label>
                    <input type="number" value={stock} onChange={(e) => setStock(e.target.value)} required />
                </div>
                <button type="submit">Guardar Producto</button>
            </form>
        </div>
    );
};

// Prop types validation
ProductForm.propTypes = {
    onProductAdded: PropTypes.func.isRequired,
};
export default ProductForm;
