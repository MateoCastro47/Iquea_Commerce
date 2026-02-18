import './Nosotros.css';

export default function Nosotros() {
    return (
        <div className="nosotros-page">
            {/* Hero Section */}
            <section className="nosotros-hero">
                <div className="nosotros-hero__content">
                    <h1 className="nosotros-hero__title">Nuestra Historia</h1>
                    <p className="nosotros-hero__subtitle">
                        Diseñando el futuro del hogar desde 2010.
                    </p>
                </div>
            </section>

            {/* Content Section */}
            <section className="nosotros-content">
                <div className="nosotros-container">
                    <div className="nosotros-block">
                        <div className="nosotros-text">
                            <h2>Quiénes Somos</h2>
                            <p>
                                Iquea nació de una idea simple: el buen diseño debe ser accesible para todos.
                                Lo que comenzó como un pequeño taller de carpintería en Madrid se ha convertido
                                en una marca referente de mobiliario moderno y funcional.
                            </p>
                            <p>
                                Creemos que tu hogar es tu santuario. Por eso, cada pieza que diseñamos
                                busca el equilibrio perfecto entre estética, durabilidad y funcionalidad.
                            </p>
                        </div>
                        <div className="nosotros-img">
                            <img
                                src="https://images.unsplash.com/photo-1581091226825-a6a2a5aee158?w=600&q=80"
                                alt="Equipo de diseño trabajando"
                            />
                        </div>
                    </div>

                    <div className="nosotros-block nosotros-block--reverse">
                        <div className="nosotros-text">
                            <h2>Nuestros Valores</h2>
                            <ul className="nosotros-values">
                                <li>
                                    <strong>Sostenibilidad:</strong> Utilizamos maderas certificadas y procesos
                                    respetuosos con el medio ambiente.
                                </li>
                                <li>
                                    <strong>Calidad:</strong> No comprometemos la durabilidad por el precio.
                                    Construimos muebles para toda la vida.
                                </li>
                                <li>
                                    <strong>Innovación:</strong> Buscamos constantemente nuevas formas de
                                    mejorar la vida en el hogar.
                                </li>
                            </ul>
                        </div>
                        <div className="nosotros-img">
                            <img
                                src="https://images.unsplash.com/photo-1531554694128-c4c6665f59c2?w=600&q=80"
                                alt="Taller de carpintería"
                            />
                        </div>
                    </div>
                </div>
            </section>

            {/* Team/Stats Section */}
            <section className="nosotros-stats">
                <div className="nosotros-container">
                    <div className="stat-item">
                        <span className="stat-number">15+</span>
                        <span className="stat-label">Años de experiencia</span>
                    </div>
                    <div className="stat-item">
                        <span className="stat-number">50k+</span>
                        <span className="stat-label">Clientes felices</span>
                    </div>
                    <div className="stat-item">
                        <span className="stat-number">100%</span>
                        <span className="stat-label">Diseño Original</span>
                    </div>
                </div>
            </section>
        </div>
    );
}
