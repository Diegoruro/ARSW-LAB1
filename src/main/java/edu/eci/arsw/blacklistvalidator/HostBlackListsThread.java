package edu.eci.arsw.blacklistvalidator;

import java.util.List;
import java.util.logging.Logger;

public class HostBlackListsThread extends Thread{

    private static final Logger LOG = Logger.getLogger(HostBlackListsThread.class.getName());
    private final String ipAddress;

    public HostBlackListsThread(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void run() {
        super.run();
        List<Integer> servers = badServersFound(ipAddress);
        LOG.info("Se encontraron "+ servers.size() +" servidores maliciosos");

    }

    public List<Integer> badServersFound(String ipAddress) {
        HostBlackListsValidator hblv=new HostBlackListsValidator();
        return hblv.checkHost("200.24.34.55", 5);
    }
}
