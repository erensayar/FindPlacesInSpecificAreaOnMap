import React from 'react'

const PlaceCard = (props) => {

    const { name, coordinate, rating, address, type, photoReference, isOpen } = props.data;

    const IMAGE_SOURCE_BASE_URL = "https://maps.googleapis.com/maps/api/place/photo?";
    const WIDTH_HEIGHT = "maxwidth=400&maxheight=400";
    const REFERENCE_PARAM = "&photo_reference=";
    const API_KEY = "&key=AIzaSyBEJYTm1zCZzI3BNiwOssWrR9jUQfQd584";
    const IMAGE_SRC = IMAGE_SOURCE_BASE_URL.concat(WIDTH_HEIGHT, REFERENCE_PARAM, photoReference, API_KEY);

    return (
        <div className="card" style={{ width: '17rem', height: '30rem' }}>
            <img className="card-img-top" src={IMAGE_SRC} alt={name} style={{ width: '15.5rem', height: '15rem' }} />
            <div className="card-body">
                <div>
                    <h5 className="card-title">{name}</h5>
                    {isOpen ? <span className="dot-online"></span> : <span className="dot-offline"></span>}
                </div>
                <p className="card-text">Rating: {rating}</p>
                <p className="card-text">Type: {type}</p>
                <p className="card-text">Address: {address}</p>
                <p className="card-text">Coordinate: {coordinate}</p>
                
            </div>
        </div>
    )
}

export default PlaceCard
