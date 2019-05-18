package com.conductor.marketpay.base.utils;

import static com.sshtools.j2ssh.authentication.AuthenticationProtocolState.COMPLETE;
import static com.sshtools.j2ssh.authentication.AuthenticationProtocolState.FAILED;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.conductor.marketpay.base.model.SFTPConfiguration;
import com.conductor.marketpay.base.model.SFTPFileValidation;
import com.sshtools.j2ssh.SftpClient;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.sftp.SftpFile;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;

public class UtilsFTP {
	
	private static boolean isFileBigger(File file, SFTPFileValidation validation) {
		final long VALUE = 1024;
		
		long fileSizeInBytes = file.length();
		long fileSizeInMegaBytes = (fileSizeInBytes / VALUE) / VALUE;
		
		
		if (validation.getMaxSize() < fileSizeInMegaBytes) {
			return true;
		}
		
		return false;
	}
	
	private static SftpClient conectar(SshClient ssh, SFTPConfiguration conf) {
	
		SftpClient client = null;
		
		try {

			if (conf.getPort() != null && StringUtils.isNotBlank(conf.getPort().toString())) {
				ssh.connect(conf.getHost(), conf.getPort(), new IgnoreHostKeyVerification());
			} else {
				ssh.connect(conf.getHost(), new IgnoreHostKeyVerification());
			}
			
			PasswordAuthenticationClient auth = new PasswordAuthenticationClient();
			
			auth.setUsername(conf.getUsername());
			auth.setPassword(conf.getPassword()); //TODO CRIPTOGRAFAR SENHA
			
			int status = ssh.authenticate(auth);
			
			switch(status) {
				case COMPLETE: 
					client = ssh.openSftpClient();
					break;
				case FAILED:
					throw new Exception("error.inicializacao");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return client;
		
	}
	
	@SuppressWarnings("unchecked")
	public static File isFilePresent(SFTPConfiguration conf, SFTPFileValidation validation) throws FileNotFoundException, BiggerFileException {
		SshClient ssh = null;
		File fileFounded = null;
		
		try {
			ssh = new SshClient();
			SftpClient client = conectar(ssh, conf);
			
			List<SftpFile> files = client.ls();
			
			if ( files.size() == 0 ) {
				throw new FileNotFoundException();
			}
			
			for (SftpFile f : files) {
				if (f.isFile()) {
					client.get(validation.getPath() + File.separator + validation.getFileName());
					fileFounded = new File(f.getAbsolutePath() + f.getFilename());
					if (isFileBigger(fileFounded, validation)) {
						throw new BiggerFileException();
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			throw e;
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return fileFounded;
	}
	
	

}
