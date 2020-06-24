USE [master]
GO
/****** Object:  Database [LNT]    Script Date: 24/6/2020 8:15:38 AM ******/
CREATE DATABASE [LNT]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'LNT', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\LNT.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'LNT_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\LNT_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [LNT] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [LNT].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [LNT] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [LNT] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [LNT] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [LNT] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [LNT] SET ARITHABORT OFF 
GO
ALTER DATABASE [LNT] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [LNT] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [LNT] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [LNT] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [LNT] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [LNT] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [LNT] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [LNT] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [LNT] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [LNT] SET  DISABLE_BROKER 
GO
ALTER DATABASE [LNT] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [LNT] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [LNT] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [LNT] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [LNT] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [LNT] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [LNT] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [LNT] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [LNT] SET  MULTI_USER 
GO
ALTER DATABASE [LNT] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [LNT] SET DB_CHAINING OFF 
GO
ALTER DATABASE [LNT] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [LNT] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [LNT] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [LNT] SET QUERY_STORE = OFF
GO
USE [LNT]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 24/6/2020 8:15:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MaNV] [nvarchar](50) NOT NULL,
	[TenNV] [nvarchar](50) NULL,
	[LoaiHopDong] [nvarchar](50) NULL,
	[HeSoLuong] [float] NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[NHANVIEN] ([MaNV], [TenNV], [LoaiHopDong], [HeSoLuong]) VALUES (N'NV1', N'Nguyen Van A', N'chinhthuc', 12)
INSERT [dbo].[NHANVIEN] ([MaNV], [TenNV], [LoaiHopDong], [HeSoLuong]) VALUES (N'NV2', N'Tran Van B', N'hopdong', 14)
INSERT [dbo].[NHANVIEN] ([MaNV], [TenNV], [LoaiHopDong], [HeSoLuong]) VALUES (N'NV3', N'Nguyen Le C', N'hopdong', 13)
USE [master]
GO
ALTER DATABASE [LNT] SET  READ_WRITE 
GO
