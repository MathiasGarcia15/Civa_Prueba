import { useState, useEffect } from 'react'
import './App.css'
 
function App() {
  const [buses, setBuses] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)
  const [page, setPage] = useState(0)
  const [totalPages, setTotalPages] = useState(0)
 
  const CREDENTIALS = btoa('admin:admin123') // Basic Auth
 
  useEffect(() => {
    fetchBuses()
  }, [page])
 
  const fetchBuses = () => {
    setLoading(true)
    fetch(`http://localhost:8080/bus?page=${page}&size=5`, {
      headers: {
        'Authorization': `Basic ${CREDENTIALS}`
      }
    })
      .then(res => {
        if (!res.ok) throw new Error('Error al obtener los buses')
        return res.json()
      })
      .then(data => {
        setBuses(data.content)
        setTotalPages(data.totalPages)
        setLoading(false)
      })
      .catch(err => {
        setError(err.message)
        setLoading(false)
      })
  }
 
  const verDetalle = (id) => {
    fetch(`http://localhost:8080/bus/${id}`, {
      headers: {
        'Authorization': `Basic ${CREDENTIALS}`
      }
    })
      .then(res => res.json())
      .then(data => {
        console.log(data)
        alert(
          `ID: ${data.id}\n` +
          `Número: ${data.numBus}\n` +
          `Placa: ${data.placa}\n` +
          `Marca: ${data.marca}\n` +
          `Características: ${data.caracteristicas}\n` +
          `Activo: ${data.activo ? 'Sí' : 'No'}\n` +
          `Fecha creación: ${formatFecha(data.fechaCrea)}`
        )
      })
      .catch(() => alert('Error al obtener el detalle'))
  }

  const formatFecha = (fecha) => {
  if (!fecha) return '-'
  if (Array.isArray(fecha)) {
    const [year, month, day] = fecha
    return `${day}/${month}/${year}`
  }
  return new Date(fecha).toLocaleDateString()
}
 
  return (
    <div className="container">
      <h1>Lista de Buses</h1>
 
      {loading && <p>Cargando...</p>}
      {error && <p style={{ color: 'red' }}>{error}</p>}
 
      {!loading && !error && (
        <>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Número</th>
                <th>Placa</th>
                <th>Marca</th>
                <th>Características</th>
                <th>Activo</th>
                <th>Fecha Creación</th>
                <th>Detalle</th>
              </tr>
            </thead>
            <tbody>
              {buses.map(bus => (
                <tr key={bus.id}>
                  <td>{bus.id}</td>
                  <td>{bus.numBus}</td>
                  <td>{bus.placa}</td>
                  <td>{bus.marca}</td>
                  <td>{bus.caracteristicas}</td>
                  <td>{bus.activo ? 'Sí' : 'No'}</td>
                  <td>{formatFecha(bus.fechaCrea)}</td>
                  <td>
                    <button onClick={() => verDetalle(bus.id)}>Ver</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
 
          <div className="pagination">
            <button
              disabled={page === 0}
              onClick={() => setPage(page - 1)}
            >
              Anterior
            </button>
            <span>Página {page + 1} de {totalPages}</span>
            <button
              disabled={page + 1 >= totalPages}
              onClick={() => setPage(page + 1)}
            >
              Siguiente
            </button>
          </div>
        </>
      )}
    </div>
  )
}
 
export default App