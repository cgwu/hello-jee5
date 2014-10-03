package com.cg.webSocketServlets;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class WebSocketChatServlet extends WebSocketServlet
{
	private static final long serialVersionUID = -3351937158623368170L;
	private final Set<ChatWebSocket> _members = new CopyOnWriteArraySet<ChatWebSocket>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws javax.servlet.ServletException ,IOException 
    {
        getServletContext().getNamedDispatcher("default").forward(request,response);
    };
    
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol)
    {
        return new ChatWebSocket();
    }

    class ChatWebSocket implements WebSocket.OnTextMessage {
        private Connection _connection;

        public void onClose(int closeCode, String message) {
            _members.remove(this);
        }

        public void sendMessage(String data) throws IOException {
            _connection.sendMessage(data);
        }
    
        public void onMessage(String data) {
            System.out.println("接收到: "+data);
        }

        public boolean isOpen() {
            return _connection.isOpen();
        }


        public void onOpen(Connection connection) {
            _members.add(this);
            _connection = connection;
            try {
                connection.sendMessage("onOpen:Server received Web Socket upgrade and added it to Receiver List.服务器成功接收此Websocket连接!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}