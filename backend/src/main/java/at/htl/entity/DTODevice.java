package at.htl.entity;

import org.json.JSONObject;

public class DTODevice {

    Device device;

    JSONObject devices;

    public DTODevice(Device device, JSONObject devices) {
        this.device = device;
        this.devices = devices;
    }

  @Override
  public String toString() {
    return "{" + device +
      ", devices=" + devices +
      '}';
  }
}
