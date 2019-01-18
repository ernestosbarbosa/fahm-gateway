package br.com.ernestobarbosa.gateway.config;

public class Constants {

    public static final String START_QUEUE = "start";
    public static final String UPLOAD_DIR = "/home/ernesto/Documentos/upload/";
    public static final String COMPLETED_DIR = "/home/ernesto/Documentos/completed/";

    public enum KeyPointsData {
        X(0),
        Y(1),
        ACCURACY(2);

        public int idData;
        KeyPointsData(int value) {
            idData = value;
        }
    }

    public enum KeyPointsBody25 {
        NOSE(0),
        NECK(1),
        RSHOULDER(2),
        RELBOW(3),
        RWRIST(4),
        LSHOULDER(5),
        LELBOW(6),
        LWRIST(7),
        MIDHIP(8),
        RHIP(9),
        RKNEE(10),
        RANKLE(11),
        LHIP(12),
        LKNEE(13),
        LANKLE(14),
        REYE(15),
        LEYE(16),
        REAR(17),
        LEAR(18),
        LBIGTOE(19),
        LSMALLTOE(20),
        LHEEL(21),
        RBIGTOE(22),
        RSMALLTOE(23),
        RHEEL(24),
        BACKGROUND(25);

        public int idKeyPoint;
        KeyPointsBody25(int value) {
            idKeyPoint = value;
        }
    }

}
