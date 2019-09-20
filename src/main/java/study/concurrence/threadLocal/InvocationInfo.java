package study.concurrence.threadLocal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InvocationInfo {

    public String sysid;
    public String tenantid;
    public String userid;
    public String callid;
    public String token;
    public String theme;
    public String locale;
    public String logints;
    public Map<Object, Object> extendAttributes = new HashMap();
    public Map<String, String> parameters = new HashMap();

    InvocationInfo() {
    }

    public Iterator<Map.Entry<String, String>> getSummry() {
        Map<String, String> map = new HashMap();
        map.putAll(this.parameters);
        map.put("sysid", this.sysid);
        map.put("token", this.token);
        map.put("tenantid", this.tenantid);
        map.put("userid", this.userid);
        map.put("callid", this.callid);
        map.put("locale", this.locale);
        map.put("logints", this.logints);
        return map.entrySet().iterator();
    }
}
