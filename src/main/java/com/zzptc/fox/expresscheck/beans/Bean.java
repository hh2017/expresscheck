package com.zzptc.fox.expresscheck.beans;

import org.json.JSONObject;

import java.util.List;

/**
 *
 * @auther : wanderders
 * @date : 2016/10/25
 * @instructions :
 *
 */
public class Bean extends JSONObject {


    /**
     * EBusinessID : 1266977
     * ShipperCode : YD
     * Success : true
     * LogisticCode : 3944950271428
     * State : 3
     * Traces : [{"AcceptTime":"2016-10-13 18:10:56","AcceptStation":"到达：福建龙海市公司 已收件"},{"AcceptTime":"2016-10-13 21:42:31","AcceptStation":"到达：福建龙海市公司 发往：湖北武汉网点包"},{"AcceptTime":"2016-10-14 02:43:18","AcceptStation":"到达：福建晋江分拨中心"},{"AcceptTime":"2016-10-14 02:45:27","AcceptStation":"到达：福建晋江分拨中心 发往：湖北武汉分拨中心"},{"AcceptTime":"2016-10-14 21:18:43","AcceptStation":"到达：湖北武汉分拨中心 上级站点：福建晋江分拨中心"},{"AcceptTime":"2016-10-15 00:52:52","AcceptStation":"到达：湖北武汉分拨中心 发往：湖北武汉洪山区白沙洲公司"},{"AcceptTime":"2016-10-15 09:38:01","AcceptStation":"到达：湖北武汉洪山区白沙洲公司 指定：工商(18986290165) 派送"},{"AcceptTime":"2016-10-15 11:08:53","AcceptStation":"已签收，签收人：工商，感谢使用韵达，期待再次为您服务"}]
     */

    private String EBusinessID;
    private String ShipperCode;
    private boolean Success;
    private String LogisticCode;
    private String State;
    /**
     * AcceptTime : 2016-10-13 18:10:56
     * AcceptStation : 到达：福建龙海市公司 已收件
     */

    private List<TracesBean> Traces;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String ShipperCode) {
        this.ShipperCode = ShipperCode;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String LogisticCode) {
        this.LogisticCode = LogisticCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public List<TracesBean> getTraces() {
        return Traces;
    }

    public void setTraces(List<TracesBean> Traces) {
        this.Traces = Traces;
    }

    public static class TracesBean {
        private String AcceptTime;
        private String AcceptStation;

        public String getAcceptTime() {
            return AcceptTime;
        }

        public void setAcceptTime(String AcceptTime) {
            this.AcceptTime = AcceptTime;
        }

        public String getAcceptStation() {
            return AcceptStation;
        }

        public void setAcceptStation(String AcceptStation) {
            this.AcceptStation = AcceptStation;
        }
    }
}
