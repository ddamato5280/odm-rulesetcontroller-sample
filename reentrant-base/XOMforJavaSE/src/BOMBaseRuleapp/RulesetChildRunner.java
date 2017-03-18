package BOMBaseRuleapp;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

import ilog.rules.res.model.*;
import ilog.rules.res.session.*;
import ilog.rules.res.session.config.*;

public class RulesetChildRunner {
        private static IlrSessionFactory factory;
        public static IlrSessionResponse execute(String path, Map<String, Object> params) throws IlrSessionException, IlrFormatException {
                IlrSessionFactory f;
                IlrStatelessSession sess;
                IlrSessionRequest rq;

                f = getFactory();

                sess = f.createStatelessSession();
                rq = f.createRequest();
                rq.setRulesetPath(IlrPath.parsePath(path));

                if (params != null)
                        rq.setInputParameters(params);

                return sess.execute(rq);
        }

        private static IlrSessionFactory getFactory() {
                IlrSessionFactoryConfig cfg;
                IlrXUConfig xuCfg;

                synchronized (RulesetChildRunner.class) {
                        if (factory == null) {
                                cfg = IlrJ2SESessionFactory.createDefaultConfig();
                                xuCfg = cfg.getXUConfig();

                                xuCfg.setLogAutoFlushEnabled(true);
                                xuCfg.setLogLevel(Level.ALL);
                                xuCfg.setLogWriter(new PrefixedPrintWriter(System.out, "[XUCHILD] "));

                                cfg.setXOMClassLoader(RulesetChildRunner.class.getClassLoader());

                                factory = new SessionFactory(cfg);
                        }
                 }
                 return factory;
        }
        private static class PrefixedPrintWriter extends PrintWriter {
                private final String prefix;

                public PrefixedPrintWriter(PrintStream out, String prefix) {
                        super(out);
                        this.prefix = prefix;
                }
                @Override
                public void write(String s) {
                        super.write(prefix + s);
                }
        }
        private static class SessionFactory extends IlrJ2SESessionFactory {
                public SessionFactory(IlrSessionFactoryConfig cfg) {
                        super(cfg);
                }

                @Override
                public void finalize() {
                        release();
                }
        }
}