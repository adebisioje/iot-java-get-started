package com.mycompany.app;
import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.RegistryManager;

import java.io.IOException;
import java.net.URISyntaxException;




public class App 
{
private static final String connectionString = "HostName=adojeiothub.azure-devices.net;SharedAccessKeyName=service;SharedAccessKey=CrFDMAo/h4VxIGs8A87/1+sKUtR626FXru16Ck9Qkq0=";
private static final String deviceId = "myFirstJavaDevice";




  public static void main( String[] args ) throws IOException, URISyntaxException, Exception


    {
    
 RegistryManager registryManager = RegistryManager.createFromConnectionString(connectionString);

 Device device = Device.createFromId(deviceId, null, null);
 try {
   device = registryManager.addDevice(device);
 } catch (IotHubException iote) {
   try {
     device = registryManager.getDevice(deviceId);
   } catch (IotHubException iotf) {
     iotf.printStackTrace();
   }
 }
 System.out.println("Device ID: " + device.getDeviceId());
 System.out.println("Device key: " + device.getPrimaryKey());

 }

}
