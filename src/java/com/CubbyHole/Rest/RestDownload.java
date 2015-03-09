/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Christopher
 */
@Path("/download")
public class RestDownload {
    
    @GET
    @Path("/test")
    public Response getFile() throws IOException{
            String filePath = "\\\\win-dsnq5dd7d85\\CubbyHole\\1\\UML3NET.jpg";
            File file = new File(filePath);
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            
            //parse to Json
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(in);
                String output = json;
		return Response.status(200).entity(output).build();

    }
}