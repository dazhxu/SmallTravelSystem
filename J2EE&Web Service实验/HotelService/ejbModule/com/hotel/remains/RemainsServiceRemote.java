package com.hotel.remains;

import javax.ejb.Remote;

@Remote
public interface RemainsServiceRemote {
	public int getRemains(String type);
	public boolean setRemains(String type, int num);
}
