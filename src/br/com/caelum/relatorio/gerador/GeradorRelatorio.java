package br.com.caelum.relatorio.gerador;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class GeradorRelatorio {

	private String nomeArquivo;
	private Map<String, Object> parametros;
	private JRDataSource dataSource;
	private Connection connection;

	public GeradorRelatorio(String nomeArquivo, Map<String, Object> parametros, JRDataSource dataSource) {
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
		this.dataSource = dataSource;
	}
	
	public GeradorRelatorio(String nomeArquivo, Map<String, Object> parametros) {
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
		this.dataSource = dataSource;
	}

	public void geraPDFParaOutputStream(OutputStream outputStream) {

		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.nomeArquivo, this.parametros, this.dataSource);

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();

		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

	public void geraPDFParaOutputStream(OutputStream outputStream, Connection connection) {

		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.nomeArquivo, this.parametros, connection);

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();

		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

}
