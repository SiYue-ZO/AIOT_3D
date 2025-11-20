package com.city3d.dao.entry;

public class PeopleRoute {
    private String routeId;

    private String keyId;

    private String cardPosition;

    private KeyPeople keyPeople;
    
    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? null : keyId.trim();
    }

    public String getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(String cardPosition) {
        this.cardPosition = cardPosition == null ? null : cardPosition.trim();
    }

	public KeyPeople getKeyPeople() {
		return keyPeople;
	}

	public void setKeyPeople(KeyPeople keyPeople) {
		this.keyPeople = keyPeople;
	}
    
    
}